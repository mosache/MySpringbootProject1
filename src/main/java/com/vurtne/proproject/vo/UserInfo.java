package com.vurtne.proproject.vo;

import lombok.Data;

@Data
public class UserInfo {

    /**
     * gists_url : https://api.github.com/users/mosache/gists{/gist_id}
     * repos_url : https://api.github.com/users/mosache/repos
     * two_factor_authentication : false
     * following_url : https://api.github.com/users/mosache/following{/other_user}
     * bio : null
     * created_at : 2015-02-24T04:59:14Z
     * login : mosache
     * type : User
     * blog :
     * private_gists : 0
     * total_private_repos : 0
     * subscriptions_url : https://api.github.com/users/mosache/subscriptions
     * updated_at : 2019-06-25T08:25:10Z
     * site_admin : false
     * disk_usage : 61891
     * collaborators : 0
     * company : null
     * owned_private_repos : 0
     * id : 11170855
     * public_repos : 26
     * gravatar_id :
     * plan : {"private_repos":10000,"name":"free","collaborators":0,"space":976562499}
     * email : null
     * organizations_url : https://api.github.com/users/mosache/orgs
     * hireable : null
     * starred_url : https://api.github.com/users/mosache/starred{/owner}{/repo}
     * followers_url : https://api.github.com/users/mosache/followers
     * public_gists : 0
     * url : https://api.github.com/users/mosache
     * received_events_url : https://api.github.com/users/mosache/received_events
     * followers : 0
     * avatar_url : https://avatars0.githubusercontent.com/u/11170855?v=4
     * events_url : https://api.github.com/users/mosache/events{/privacy}
     * html_url : https://github.com/mosache
     * following : 1
     * name : null
     * location : null
     * node_id : MDQ6VXNlcjExMTcwODU1
     */
    private String gists_url;
    private String repos_url;
    private boolean two_factor_authentication;
    private String following_url;
    private String bio;
    private String created_at;
    private String login;
    private String type;
    private String blog;
    private int private_gists;
    private int total_private_repos;
    private String subscriptions_url;
    private String updated_at;
    private boolean site_admin;
    private int disk_usage;
    private int collaborators;
    private String company;
    private int owned_private_repos;
    private int id;
    private int public_repos;
    private String gravatar_id;
    private PlanEntity plan;
    private String email;
    private String organizations_url;
    private String hireable;
    private String starred_url;
    private String followers_url;
    private int public_gists;
    private String url;
    private String received_events_url;
    private int followers;
    private String avatar_url;
    private String events_url;
    private String html_url;
    private int following;
    private String name;
    private String location;
    private String node_id;


    @Data
    public class PlanEntity {
        /**
         * private_repos : 10000
         * name : free
         * collaborators : 0
         * space : 976562499
         */
        private int private_repos;
        private String name;
        private int collaborators;
        private int space;
    }


}
