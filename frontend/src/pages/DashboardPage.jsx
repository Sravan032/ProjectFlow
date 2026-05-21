import { useEffect, useState } from "react";

import {
    getAllTasks,
    createTask
} from "../services/TaskService";

import {
    getAllProjects,
    createProject
} from "../services/ProjectService";
import { getCurrentUser } from "../services/UserService";


function DashboardPage() {

    const [tasks, setTasks] = useState([]);

    const [projects, setProjects] = useState([]);

    const [projectForm, setProjectForm] = useState({

        title: "",
        description: "",
        deadline: ""
    });

    const [taskForm, setTaskForm] = useState({

        title: "",
        description: "",
        status: "TODO",
        priority: "MEDIUM",
        projectId: "",
        assignedUserId: ""
    });
    const [user, setUser] = useState(null);

    useEffect(() => {

        fetchData();

    }, []);

    const fetchData = async () => {

        try {

            const taskData = await getAllTasks();

            const projectData = await getAllProjects();
            const userData = await getCurrentUser();

            setUser(userData);

            setTasks(taskData);

            setProjects(projectData);

        } catch (error) {

            console.log(error);
        }
    };
    const handleProjectSubmit = async (e) => {

        e.preventDefault();

        try {

            await createProject(projectForm);

            fetchData();

        } catch (error) {

            console.log(error);
        }
    };
    const handleTaskSubmit = async (e) => {

        e.preventDefault();

        try {

            await createTask(taskForm);

            fetchData();

        } catch (error) {

            console.log(error);
        }
    };

    return (

        <div className="container">

            <h1>Dashboard</h1>

            <hr />
    {
        user?.role === "ADMIN" && (
            <>
        <div className="card">
            <h2>Create Project</h2>


            <form onSubmit={handleProjectSubmit}>

                <input
                    type="text"
                    placeholder="Project Title"
                    onChange={(e) =>
                        setProjectForm({
                            ...projectForm,
                            title: e.target.value
                        })
                    }
                />

                <br /><br />

                <input
                    type="text"
                    placeholder="Description"
                    onChange={(e) =>
                        setProjectForm({
                            ...projectForm,
                            description: e.target.value
                        })
                    }
                />

                <br /><br />

                <input
                    type="date"
                    onChange={(e) =>
                        setProjectForm({
                            ...projectForm,
                            deadline: e.target.value
                        })
                    }
                />

                <br /><br />

                <button type="submit">
                    Create Project
                </button>

            </form>
        </div>


            <hr />
            </>
        )
    }
        <div className="card">
            <h2>Create Task</h2>

            <form onSubmit={handleTaskSubmit}>

                <input
                    type="text"
                    placeholder="Task Title"
                    onChange={(e) =>
                        setTaskForm({
                            ...taskForm,
                            title: e.target.value
                        })
                    }
                />

                <br /><br />

                <input
                    type="text"
                    placeholder="Description"
                    onChange={(e) =>
                        setTaskForm({
                            ...taskForm,
                            description: e.target.value
                        })
                    }
                />

                <br /><br />

                <select
                    onChange={(e) =>
                        setTaskForm({
                            ...taskForm,
                            status: e.target.value
                        })
                    }
                >

                    <option value="TODO">TODO</option>

                    <option value="IN_PROGRESS">
                        IN_PROGRESS
                    </option>

                    <option value="COMPLETED">
                        COMPLETED
                    </option>

                </select>

                <br /><br />

                <select
                    onChange={(e) =>
                        setTaskForm({
                            ...taskForm,
                            priority: e.target.value
                        })
                    }
                >

                    <option value="LOW">LOW</option>

                    <option value="MEDIUM">MEDIUM</option>

                    <option value="HIGH">HIGH</option>

                </select>

                <br /><br />

                <input
                    type="number"
                    placeholder="Project ID"
                    onChange={(e) =>
                        setTaskForm({
                            ...taskForm,
                            projectId: e.target.value
                        })
                    }
                />

                <br /><br />

                <input
                    type="number"
                    placeholder="Assigned User ID"
                    onChange={(e) =>
                        setTaskForm({
                            ...taskForm,
                            assignedUserId: e.target.value
                        })
                    }
                />

                <br /><br />

                <button type="submit">
                    Create Task
                </button>

            </form>
        </div>

            <hr />

            <h2>Projects</h2>

            {

                projects.map((project) => (

                    <div className="card" key={project.id}>

                        <h3>{project.title}</h3>

                        <p>{project.description}</p>

                        <p>{project.deadline}</p>

                        <hr />

                    </div>
                ))
            }

            <h2>Tasks</h2>

            {

                tasks.map((task) => (

                    <div className="card" key={task.id}>

                        <h3>{task.title}</h3>

                        <p>{task.description}</p>

                        <p>Status: {task.status}</p>

                        <p>Priority: {task.priority}</p>

                        <hr />

                    </div>
                ))
            }

        </div>
    );
}

export default DashboardPage;