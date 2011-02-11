package com.mycompany.dewcineplanetplusg6b.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mycompany.dewcineplanetplusg6b.model.Sala;

public class SalaTest {
	SalaRepository salaRepository = new SalaRepository();
	
	@Test
	public void obtenerSalas(){
		List<Sala> salas = salaRepository.obtenerTodasSalas();
			assertTrue (salas.size()>0);
		
	}
	
	@Test
	public void elegirButaca(){
		List<Sala> salas = salaRepository.obtenerTodasSalas();
		String butaca = "A2";
		for(int i=0; i<salas.size();i++){
			if(butaca.equals(salas.get(i).getFila() + salas.get(i).getCodButaca())&&(salas.get(i).getEstado().equals("LIBRE"))){
				salas.get(i).setEstado("RESERVADO");
				System.out.print(salas.get(i).getEstado());
				assertEquals("RESERVADO", salas.get(i).getEstado());
				break;
			}}}}

