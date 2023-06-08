import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const AddUsers = () => {
  const navigate = useNavigate();
  const [values, setValues] = useState({
    username: "",
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setValues({ ...values, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const { username, email, password } = values;
    try {
      await fetch("/user/create", {
        method: "POST",
        credentials: "include",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ username, email, password }),
      });
      navigate("/admin", { msg: "user successfully added" });

      //  .then(response => response.json())
    } catch (error) {
      console.log(error);
    }

    const userDetail = { username, password, email };
    console.log(userDetail);
  };

  return (
    <div className="container my-3">
      <h2 className="my-3">Add users</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group mb-3">
          <label className="mb-1" htmlFor="username">
            Username
          </label>
          <input
            type="text"
            name="username"
            value={values.username}
            placeholder="enter username"
            className="form-control"
            onChange={handleChange}
          />
        </div>
        <div className="form-group mb-3">
          <label className="mb-1" htmlFor="email">
            Email
          </label>
          <input
            type="email"
            name="email"
            placeholder="enter email"
            className="form-control"
            value={values.email}
            onChange={handleChange}
          />
        </div>
        <div className="form-group mb-3">
          <label className="mb-1" htmlFor="author">
            Password
          </label>
          <input
            type="password"
            name="password"
            placeholder="enter password"
            className="form-control"
            value={values.password}
            onChange={handleChange}
          />
        </div>

        <button type="submit" className="btn btn-primary text-light mt-3">
          Add
        </button>
      </form>
      <Link className="btn btn-outline-primary mt-3" to="/admin">
        Cancel
      </Link>
    </div>
  );
};

export default AddUsers;
