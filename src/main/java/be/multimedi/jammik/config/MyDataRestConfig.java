package be.multimedi.jammik.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * made by Koen
 */

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        HttpMethod[] theUnsupportedActions = { HttpMethod.DELETE};
//
//        // disabel HTTP methods for Product: PUT, POST and DELETE
//
//        config.getExposureConfiguration().forDomainType(Photo.class).withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)).withCollectionExposure((metdata, httpMethods) ->
//                httpMethods.disable(theUnsupportedActions));
//
//        config.getExposureConfiguration().forDomainType(Comment.class).withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)).withCollectionExposure((metdata, httpMethods) ->
//                httpMethods.disable(theUnsupportedActions));
//
//        config.getExposureConfiguration().forDomainType(User.class).withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)).withCollectionExposure((metdata, httpMethods) ->
//                httpMethods.disable(theUnsupportedActions));

        // call an internal helper method to expose Id's
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        //expose entity ids
        //

        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        //-
        List<Class> entityClasses = new ArrayList<>();

        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        //- expose the entity ids for the array/ domain types’
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
