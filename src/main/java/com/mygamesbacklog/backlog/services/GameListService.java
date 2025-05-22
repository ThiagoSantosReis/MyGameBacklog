package com.mygamesbacklog.backlog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mygamesbacklog.backlog.dto.GameListDTO;
import com.mygamesbacklog.backlog.entities.GameList;
import com.mygamesbacklog.backlog.repositories.GameListRepository;

@Component //Component (ou @Service) precisa ser registrado pelo framework
public class GameListService {
	//Service é o componente responsável por implementar uma regra de negócio
	
	@Autowired 
	private GameListRepository gameListRepository;
	
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
}
