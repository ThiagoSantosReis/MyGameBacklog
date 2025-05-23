package com.mygamesbacklog.backlog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mygamesbacklog.backlog.dto.GameDTO;
import com.mygamesbacklog.backlog.dto.GameMinDTO;
import com.mygamesbacklog.backlog.entities.Game;
import com.mygamesbacklog.backlog.projections.GameMinProjection;
import com.mygamesbacklog.backlog.repositories.GameRepository;


@Component //Component (ou @Service) precisa ser registrado pelo framework
public class GameService {
	//Service é o componente responsável por implementar uma regra de negócio
	
	@Autowired 
	private GameRepository gameRepository;
	
	//Garante que a operação com o banco de dados aconteça
	@org.springframework.transaction.annotation.Transactional(readOnly = true) 
	public GameDTO findById(Long id) {
		//Implementar tratamento de excessão caso não exista ID
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);
		
	}
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		var result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
}
