/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring.boardgame.registerboardgame.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boardgame.registerboardgame.model.display.SingleGamesession;
import spring.boardgame.registerboardgame.model.display.DisplayParticipation;
import spring.boardgame.registerboardgame.repository.FactionRepository;
import spring.boardgame.registerboardgame.repository.ScenarioRepository;


/**
 *
 * @author stevi
 */
@Service
public class AuxillaryFetcher {
    
    @Autowired
    private FactionRepository factionrep; 
    
    @Autowired
    private ScenarioRepository scenariorep; 
    
    public SingleGamesession addSingleGameSessionAuxillaries(SingleGamesession gamenight){

        if(gamenight.getScenarioId() != null && gamenight.getScenarioId() > 0){
            gamenight.setScenario(this.scenariorep.findById(gamenight.getScenarioId()).get());
        }
        
        for(DisplayParticipation part: gamenight.getDeltakelser()){
            if(part.getFraksjonID() != null && part.getFraksjonID() > 0){
                part.setFraksjon(this.factionrep.findById(new Long(part.getFraksjonID())).get());
            }
        }
        
        return gamenight;
    }
    
}
