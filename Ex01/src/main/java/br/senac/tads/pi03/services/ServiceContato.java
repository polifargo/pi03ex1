
package br.senac.tads.pi03.services;

import br.senac.tads.pi03.dao.DaoContato;
import br.senac.tads.pi03.exceptions.ContatoException;
import br.senac.tads.pi03.exceptions.DataSourceException;


public class ServiceContato {
        //Insere um contato na fonte de dados
    public static void cadastrarContato(String nomeContato, String nascContato,
            String telefoneContato, String emailContato, String horario) 
            throws ContatoException, DataSourceException {
        //Realização de validações dos campos 
        if ("".equals(nomeContato) || "  /  /    ".equals(nascContato)
                || "".equals(emailContato) || "".equals(telefoneContato)) {
            throw new ContatoException("Um ou mais campos estão vazios, convém preenche-los!");
        } else if (!emailContato.contains("@") && !emailContato.contains(".")) {
            throw new ContatoException("E-mail incorreto!");
        }
        try {
            //Realiza a chamada de inserção na fonte de dados
            DaoContato.inserir(nomeContato, nascContato, telefoneContato, emailContato, horario);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
}
