package Servisos;

import model.Cena;
import model.Console;
import model.Item;
import model.Save;
import repositorio.CenaDAO;
import repositorio.ItemDAO;
import repositorio.SaveDAO;

public class   ComandoServico {
    private String[] comando;
    private Console console;

    public ComandoServico(String comandoBruto){
        Console console = new Console();
        this.console = console;
        this.comando = comandoBruto.split(" ");
    }

    public Console useItem() {
        if (comando.length < 2) {
            console.setMensagem("Comando inválido. O formato correto é: USE [ITEM]");
            return console;
        }

        String nomeItem = comando[1];
        try {
            Item item = ItemDAO.findItemByNome(nomeItem);

            if (item == null) {
                console.setMensagem("Item '" + nomeItem + "' não encontrado.");
                return console;
            }

            if (item.getCenaAtual() != null) {
                Cena proximaCena = CenaDAO.FindCenaById(item.getCenaAtual());
                console.setMensagem(proximaCena.getDescricao());
            } else {
                console.setMensagem("Este item não pode ser usado aqui.");
            }

            return console;

        } catch (Exception e) {
            e.printStackTrace();
            console.setMensagem("Erro ao tentar usar o item.");
            return console;
        }
    }

    public Console help() {
        console.setMensagem(
                "O objetivo do text adventure é o usuário interagir com os objetos descritos na cena " +
                        "(identificados pelos nomes em letra maiúsculas) para avançar no jogo.\n" +
                        "Os comandos possíveis são:\n" +
                        "HELP: exibe o menu de ajuda do jogo\n" +
                        "USE [ITEM]: interage com o item da cena\n" +
                        "SAVE: salva o jogo\n" +
                        "LOAD: carrega um jogo salvo\n" +
                        "RESTART: reinicia o jogo"
        );
        return console;
    }
    public Console loadGame() {
        if (comando.length < 2) {
            console.setMensagem("Comando inválido. O formato correto é: loading [ID_DO_SAVE]");
            return console;
        }

        try {
            int idSave = Integer.parseInt(comando[1]);

            Save save = SaveDAO.findSaveById(idSave);

            if (save != null) {
                console.setMensagem("Jogo carregado com sucesso!\n" + save.getCenaatual().getDescricao());
                console.setIdSave(save.getIdSave());
            } else {
                console.setMensagem("Save com ID '" + idSave + "' não encontrado.");
            }

            return console;

        } catch (NumberFormatException e) {
            console.setMensagem("ID do save inválido. Deve ser um número.");
            return console;
        } catch (Exception e) {
            console.setMensagem("Erro ao carregar o jogo.");
            e.printStackTrace();
            return console;
        }
    }


    public Console start(){
        try {
            Save save = SaveDAO.novoJogo();
            console.setMensagem(save.getCenaatual().getDescricao());
            console.setIdSave(save.getIdSave());
            return console;
        } catch (Exception e){
            e.printStackTrace();
            console.setMensagem("Erro ao iniciar o jogo");
            return console;
        }

    }

    public Console resetGame() {
        try {
            if (console.getIdSave() == null) {
                console.setMensagem("Nenhum jogo em andamento para reiniciar.");
                return console;
            }
            boolean resetSucesso = SaveDAO.resetSaveToInitialScene(console.getIdSave());

            if (resetSucesso) {
                // Busca a descrição da cena inicial após o reset
                Cena cenaInicial = CenaDAO.FindCenaById(1);
                console.setMensagem("Jogo reiniciado com sucesso!\n" + cenaInicial.getDescricao());
            } else {
                console.setMensagem("Erro ao tentar reiniciar o jogo.");
            }

            return console;
        } catch (Exception e) {
            console.setMensagem("Erro ao reiniciar o jogo.");
            e.printStackTrace();
            return console;
        }
    }

    public Console saveGame() {
        try {
            if (console.getIdSave() == null) {
                console.setMensagem("Nenhum jogo em andamento para salvar.");
                return console;
            }
            boolean saveSucesso = SaveDAO.saveCurrentGame(console.getIdSave(), console.getIdSave());

            if (saveSucesso) {
                console.setMensagem("Jogo salvo com sucesso!");
            } else {
                console.setMensagem("Erro ao tentar salvar o jogo.");
            }

            return console;
        } catch (Exception e) {
            console.setMensagem("Erro ao salvar o jogo.");
            e.printStackTrace();
            return console;
        }
    }

    public Console getResultadoConsole() {
        try {
            String primeiroComando = comando[0].toLowerCase();

            return switch (primeiroComando) {
                case "help" -> help();
                case "start" -> start();
                case "use" -> useItem();
                case "loading" -> loadGame();
                case "save" -> saveGame();
                default -> {
                    console.setMensagem("comando invalido");
                    yield console;
                }
            };
        } catch (Exception e) {
            console.setMensagem("Comando inválido");
            return console;
        }
    }
}
