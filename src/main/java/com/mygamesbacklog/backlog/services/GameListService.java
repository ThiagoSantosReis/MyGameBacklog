package com.mygamesbacklog.backlog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mygamesbacklog.backlog.dto.GameListDTO;
import com.mygamesbacklog.backlog.entities.GameList;
import com.mygamesbacklog.backlog.projections.GameMinProjection;
import com.mygamesbacklog.backlog.repositories.GameListRepository;
import com.mygamesbacklog.backlog.repositories.GameRepository;

@Component //Component (ou @Service) precisa ser registrado pelo framework
public class GameListService {
	//Service é o componente responsável por implementar uma regra de negócio
	
	@Autowired 
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}

	@org.springframework.transaction.annotation.Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
		
	}
	
}
