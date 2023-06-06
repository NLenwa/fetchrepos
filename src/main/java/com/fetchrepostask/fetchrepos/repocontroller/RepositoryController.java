package com.fetchrepostask.fetchrepos.repocontroller;

import com.fetchrepostask.fetchrepos.model.Repository;
import com.fetchrepostask.fetchrepos.reposervice.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RepositoryController {
    private final RepositoryService repositoryService;

    @Autowired
    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping("/{username}")
    public List<Repository> getRepositories(@PathVariable String username) {
        return  repositoryService.getRepository(username);
    }

}
