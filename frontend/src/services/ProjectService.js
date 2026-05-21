import API from "./api";

export const getAllProjects = async () => {

    const response = await API.get("/projects");

    return response.data;
};

export const createProject = async (projectData) => {

    const response = await API.post(
        "/projects",
        projectData
    );

    return response.data;
};