package com.uitgis.vietlis.valuation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.uitgis.vietlis.valuation.domain.Doc;

@RepositoryRestResource(collectionResourceRel = "docs", path = "docs")
public interface DocRepository extends JpaRepository<Doc, Long> {

}
