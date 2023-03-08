package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.filter.filtroBlueprint;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service("bluePrintsService")
public class BlueprintsServices {

    @Autowired
    BlueprintsPersistence bpp=null;

    @Autowired
    @Qualifier("filtroRedundancia")
    filtroBlueprint fbp;
    public Blueprint filtro(Blueprint blueprint){
        return fbp.filtro(blueprint);
    }

    public void addNewBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        bpp.saveBlueprint(bp);
    }


    public void updateBlueprint(String author, String name, Blueprint bp) throws BlueprintPersistenceException {
        bpp.updateBlueprint(author, name, bp);
    }


    public Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException {
        return bpp.getBlueprints();
    }
    
    /**
     * 
     * @param author blueprint's author
     * @param name blueprint's name
     * @return the blueprint of the given name created by the given author
     * @throws BlueprintNotFoundException if there is no such blueprint
     */
    public Blueprint getBlueprint(String author,String name) throws BlueprintNotFoundException{
        return bpp.getBlueprint(author, name);
    }
    
    /**
     * 
     * @param author blueprint's author
     * @return all the blueprints of the given author
     * @throws BlueprintNotFoundException if the given author doesn't exist
     */
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException{
        return bpp.getBlueprintByAuthor(author);
    }

}
    
