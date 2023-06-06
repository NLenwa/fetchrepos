package com.fetchrepostask.fetchrepos.reposervice;


import com.fetchrepostask.fetchrepos.model.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class RepositoryService {

    private static final String GITHUB_API_URL = "https://api.github.com/users/";

    private RestTemplate restTemplate = new RestTemplate();

    public List<Repository> getRepository(String username) {
            String githubUrl = GITHUB_API_URL + username + "/repos";

            String response = restTemplate.getForObject(githubUrl,
                    String.class);

            System.out.println(response);
            return null;
    }

}
