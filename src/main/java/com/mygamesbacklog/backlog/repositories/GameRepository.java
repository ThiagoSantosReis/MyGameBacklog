package com.mygamesbacklog.backlog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mygamesbacklog.backlog.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	//Componente responsável por fazer consultas no banco através do JpaRepository
	
}
