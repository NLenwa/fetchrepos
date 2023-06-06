package com.fetchrepostask.fetchrepos.reposervice;


import com.fetchrepostask.fetchrepos.authentificator.Authenticator;
import com.fetchrepostask.fetchrepos.exceptions.UserRequestExceptions;
import com.fetchrepostask.fetchrepos.model.Repository;
import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.springframework.stereotype.Service;

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
            //GitHub github = GitHub.connectAnonymously();    // connect to github via Kohsuke

            // Connect with authenticator via Authenticator class
            String login = Authenticator.getLogin();
            String key = Authenticator.getAuthKey();
            GitHub github = GitHub.connect(login, key);

            //Check if user exists
            try {
                GHUser githubUser = github.getUser(username);

            } catch (IOException e) {
                throw new UserRequestExceptions(String.format("No GitHub %s user was found", username));
            }


            // List of github repositories of given user
            List<GHRepository> githubRepositories = github.getUser(username).listRepositories().toList();

            //int forkCount = 1; // fork count for easy console readability

            for (GHRepository githubRepository: githubRepositories) {

                Repository repository = new Repository();

                // Repository name variable for re-usability
                String repoName = githubRepository.getName();

                repository.setName(repoName);
                repository.setLogin(githubRepository.getOwnerName());

                // Obtain list of all branch names for given repository
                List<GHBranch> githubRepoBranches = githubRepository.getBranches().values().stream().toList();
                List<String> githubBranches = githubRepoBranches.stream().map(GHBranch::getName).toList();
                //System.out.println(githubBranches);

                String branches = "";

                // Map branch with Sha strings - MAP<> and List<> resulted in null values
                // String is used to show branch and it's SHA
                for (String branch : githubBranches) {
                    String branchSha = githubRepository.getBranch(branch).getSHA1();
                    branches += (" " + branch + ": " + branchSha + ";");
                }
                repository.setBranches(branches);

                // If given repository is not a fork, then add to repositories
                if (!githubRepository.isFork()) {
                    //System.out.println(githubRepository.getName());
                    repositories.add(repository);
                }
//                else {
//                    System.out.println("FORK #"+forkCount);
//                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return repositories;
    }

}
