package br.edu.unirn.main;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import br.edu.unirn.Pessoa;
import br.edu.unirn.impl.Cadastro;
import br.edu.unirn.impl.CadastroService;

public class Principal {

	
	public static void main(String[] args) throws DatatypeConfigurationException {
		CadastroService service =  new CadastroService();
		Cadastro cadastro = service.getCadastroImplPort();
		cadastro.work("Deu certo!!");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Romulo");
		pessoa.setAltura(12);
		pessoa.setIdade(34);
		
		GregorianCalendar gcalendar = new GregorianCalendar();
		gcalendar.setTime(new Date());
		XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcalendar);
		pessoa.setDataNascimento(xmlDate);
		
		cadastro.cadastrar(pessoa);
		cadastro.cadastrar(pessoa);
		cadastro.cadastrar(pessoa);
		
		List<Pessoa> lista = cadastro.listar();
		for(Pessoa l:lista){
			System.out.println(l.getNome());
		}
		
		
	}
}
