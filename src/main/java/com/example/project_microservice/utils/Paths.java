package com.example.project_microservice.utils;

public class Paths {

    private static final String API = "api/v1";

    // Projects
    public static final String USER_PROJECT = API + "/{userId}/projects";
    public static final String SUB_PROJECT = API + "/{userId}/subprojects";

    //Internships
    public static final String INTERNSHIP = API + "/internships";

    public static final String VACANCY = API + "/vacancies";
}
