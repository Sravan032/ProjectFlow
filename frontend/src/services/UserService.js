import API from "./api";

export const getCurrentUser = async () => {

    const response = await API.get("/users/me");

    return response.data;
};