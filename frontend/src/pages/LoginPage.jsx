import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";

import { loginUser } from "../services/authService";

function LoginPage() {

    const navigate = useNavigate();

    const [formData, setFormData] = useState({

        email: "",
        password: ""
    });

    const [message, setMessage] = useState("");

    const handleChange = (e) => {

        setFormData({

            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = async (e) => {

        e.preventDefault();

        try {

            const response = await loginUser(formData);

            // STORE JWT TOKEN
            localStorage.setItem(
                "token",
                response.token
            );

            navigate("/dashboard");

        } catch (error) {

            setMessage("Invalid email or password");
        }
    };

    return (

        <div>

            <h1>Login</h1>

            <form onSubmit={handleSubmit}>

                <input
                    type="email"
                    name="email"
                    placeholder="Enter Email"
                    onChange={handleChange}
                />

                <br /><br />

                <input
                    type="password"
                    name="password"
                    placeholder="Enter Password"
                    onChange={handleChange}
                />

                <br /><br />

                <button type="submit">
                    Login
                </button>

            </form>

            <p>{message}</p>

            <Link to="/register">
                Create New Account
            </Link>

        </div>
    );
}

export default LoginPage;