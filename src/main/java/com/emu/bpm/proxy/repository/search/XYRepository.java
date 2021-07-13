package com.emu.bpm.proxy.repository.search;


import com.emu.bpm.proxy.domain.XY;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Spring Data Elasticsearch repository for the {@link XY} entity.
 */
public interface XYRepository extends ElasticsearchRepository<XY, Long> {}
