package com.vurtne.proproject.vo;

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

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public void setTwo_factor_authentication(boolean two_factor_authentication) {
        this.two_factor_authentication = two_factor_authentication;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public void setPrivate_gists(int private_gists) {
        this.private_gists = private_gists;
    }

    public void setTotal_private_repos(int total_private_repos) {
        this.total_private_repos = total_private_repos;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public void setSite_admin(boolean site_admin) {
        this.site_admin = site_admin;
    }

    public void setDisk_usage(int disk_usage) {
        this.disk_usage = disk_usage;
    }

    public void setCollaborators(int collaborators) {
        this.collaborators = collaborators;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setOwned_private_repos(int owned_private_repos) {
        this.owned_private_repos = owned_private_repos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public void setPlan(PlanEntity plan) {
        this.plan = plan;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public void setHireable(String hireable) {
        this.hireable = hireable;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public void setPublic_gists(int public_gists) {
        this.public_gists = public_gists;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getGists_url() {
        return gists_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public boolean isTwo_factor_authentication() {
        return two_factor_authentication;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public String getBio() {
        return bio;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getLogin() {
        return login;
    }

    public String getType() {
        return type;
    }

    public String getBlog() {
        return blog;
    }

    public int getPrivate_gists() {
        return private_gists;
    }

    public int getTotal_private_repos() {
        return total_private_repos;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public boolean isSite_admin() {
        return site_admin;
    }

    public int getDisk_usage() {
        return disk_usage;
    }

    public int getCollaborators() {
        return collaborators;
    }

    public String getCompany() {
        return company;
    }

    public int getOwned_private_repos() {
        return owned_private_repos;
    }

    public int getId() {
        return id;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public PlanEntity getPlan() {
        return plan;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public String getHireable() {
        return hireable;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public int getPublic_gists() {
        return public_gists;
    }

    public String getUrl() {
        return url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public int getFollowers() {
        return followers;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public int getFollowing() {
        return following;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getNode_id() {
        return node_id;
    }

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

        public void setPrivate_repos(int private_repos) {
            this.private_repos = private_repos;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCollaborators(int collaborators) {
            this.collaborators = collaborators;
        }

        public void setSpace(int space) {
            this.space = space;
        }

        public int getPrivate_repos() {
            return private_repos;
        }

        public String getName() {
            return name;
        }

        public int getCollaborators() {
            return collaborators;
        }

        public int getSpace() {
            return space;
        }
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "gists_url='" + gists_url + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", two_factor_authentication=" + two_factor_authentication +
                ", following_url='" + following_url + '\'' +
                ", bio='" + bio + '\'' +
                ", created_at='" + created_at + '\'' +
                ", login='" + login + '\'' +
                ", type='" + type + '\'' +
                ", blog='" + blog + '\'' +
                ", private_gists=" + private_gists +
                ", total_private_repos=" + total_private_repos +
                ", subscriptions_url='" + subscriptions_url + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", site_admin=" + site_admin +
                ", disk_usage=" + disk_usage +
                ", collaborators=" + collaborators +
                ", company='" + company + '\'' +
                ", owned_private_repos=" + owned_private_repos +
                ", id=" + id +
                ", public_repos=" + public_repos +
                ", gravatar_id='" + gravatar_id + '\'' +
                ", plan=" + plan +
                ", email='" + email + '\'' +
                ", organizations_url='" + organizations_url + '\'' +
                ", hireable='" + hireable + '\'' +
                ", starred_url='" + starred_url + '\'' +
                ", followers_url='" + followers_url + '\'' +
                ", public_gists=" + public_gists +
                ", url='" + url + '\'' +
                ", received_events_url='" + received_events_url + '\'' +
                ", followers=" + followers +
                ", avatar_url='" + avatar_url + '\'' +
                ", events_url='" + events_url + '\'' +
                ", html_url='" + html_url + '\'' +
                ", following=" + following +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", node_id='" + node_id + '\'' +
                '}';
    }
}
