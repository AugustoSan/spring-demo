package com.apitest.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.apitest.demo.models.EstablishmentModel;

@Repository
public class EstablishmentRepository {
    private final MongoTemplate mongoTemplate;

    public EstablishmentRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Busca un establecimiento por su ID
     * @param id el ID del establecimiento
     * @return el establecimiento encontrado o null si no se encuentra
     */
    public EstablishmentModel findById(String id) {
        return mongoTemplate.findById(id, EstablishmentModel.class);
    }

    /**
     * Obtener todos los establecimientos
     * @return una lista con todos los establecimientos
     */
    public List<EstablishmentModel> findAll() {
        String dbName = mongoTemplate.getDb().getName();
        System.out.println("🔍 Base de datos actual: " + dbName);
        List<EstablishmentModel> establishments = mongoTemplate.findAll(EstablishmentModel.class);
        System.out.println("📊 Documentos encontrados: " + establishments.size());
        return establishments;
    }

}
