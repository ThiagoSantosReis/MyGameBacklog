package com.mygamesbacklog.backlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mygamesbacklog.backlog.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{
	//Componente responsável por fazer consultas no banco através do JpaRepository
	
}
