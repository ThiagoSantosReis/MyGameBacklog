package com.mygamesbacklog.backlog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mygamesbacklog.backlog.GameMinDTO;
import com.mygamesbacklog.backlog.repositories.GameRepository;

@Component //Component (ou @Service) precisa ser registrado pelo framework
public class GameService {
	//Service é o componente responsável por implementar uma regra de negócio
	
	@Autowired 
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		var result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
}
