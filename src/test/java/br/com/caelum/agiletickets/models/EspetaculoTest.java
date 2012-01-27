package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

public class EspetaculoTest {
	
	Espetaculo espetaculo;
	
	@Before
	public void setUp() {
		espetaculo = new Espetaculo();
	}
	
	@Test
	public void deveCriarUmaSessaoParaHoje() throws Exception {
		LocalDate inicio = new LocalDate(Calendar.getInstance().getTime());
		LocalDate fim = inicio;
		
		int numeroOriginalDeSessoes = espetaculo.getSessoes().size();
		 
		espetaculo.criaSessoes(inicio, fim, new LocalTime(), Periodicidade.DIARIA);
		
		int novoNumeroDeSessoes = espetaculo.getSessoes().size();
		
		assertEquals(numeroOriginalDeSessoes + 10, novoNumeroDeSessoes);
	}
	
	@Test
	public void deveCriarUmaSessaoPorDiaParaUmPeriodo() throws Exception {
		LocalDate inicio = new LocalDate(Calendar.getInstance().getTime());
		LocalDate fim = inicio.plusDays(30);
		
		
		int numeroOriginalDeSessoes = espetaculo.getSessoes().size();
		
		espetaculo.criaSessoes(inicio, fim, new LocalTime(), Periodicidade.DIARIA);
		
		int novoNumeroDeSessoes = espetaculo.getSessoes().size();
		
		assertEquals(numeroOriginalDeSessoes + 31, novoNumeroDeSessoes);
	}
	@Test
	public void deveCriarUmaSessaoPorSemanaParaHoje() throws Exception {
		LocalDate inicio = new LocalDate(Calendar.getInstance().getTime());
		LocalDate fim = inicio;
		
		
		int numeroOriginalDeSessoes = espetaculo.getSessoes().size();
		
		espetaculo.criaSessoes(inicio, fim, new LocalTime(), Periodicidade.SEMANAL);
		
		int novoNumeroDeSessoes = espetaculo.getSessoes().size();
		
		assertEquals(numeroOriginalDeSessoes + 1, novoNumeroDeSessoes);
	}
	
	@Test
	public void deveCriarUmaSessaoPorSemanaParaUmPeriodo() throws Exception {
		LocalDate inicio = new LocalDate(Calendar.getInstance().getTime());
		LocalDate fim = inicio.plusDays(30);
		
		
		int numeroOriginalDeSessoes = espetaculo.getSessoes().size();
		
		espetaculo.criaSessoes(inicio, fim, new LocalTime(), Periodicidade.SEMANAL);
		
		int novoNumeroDeSessoes = espetaculo.getSessoes().size();
		
		assertEquals(numeroOriginalDeSessoes + 31 / 7 + 1, novoNumeroDeSessoes);
	}
	
}
