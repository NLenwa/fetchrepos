package com.fetchrepostask.fetchrepos.reposervice;


import com.fetchrepostask.fetchrepos.model.Repository;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryService {

    //private static final String GITHUB_API_URL = "https://api.github.com/users/";

    //private RestTemplate restTemplate = new RestTemplate();

    public List<Repository> getRepository(String username) {
        //String githubUrl = GITHUB_API_URL + username + "/repos";

        List<Repository> repositories = new ArrayList<>();

        try {
            GitHub github = GitHub.connectAnonymously();
            List<GHRepository> githubRepositories = github.getUser(username).listRepositories().toList();

            int forkCount = 1;
            for (GHRepository githubRepository: githubRepositories) {
                Repository repository = new Repository();

                repository.setName(githubRepository.getName());
                repository.setLogin(githubRepository.getOwnerName());

                if (!githubRepository.isFork()) {
                    System.out.println(githubRepository.getName());
                    repositories.add(repository);
                } else {
                    System.out.println("FORK #"+forkCount);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return repositories;
    }

}
