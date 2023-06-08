import React, { useState, useEffect } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

const EditUser = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const [user, setUser] = useState({
    username: "",
    email: "",
    password: "",
  });

  useEffect(() => {
    const getUser = async () => {
      try {
        const resp = await fetch(`/user/${id}`);
        const data = await resp.json();
        setUser(data);
      } catch (error) {
        console.log(error);
      }
    };
    getUser();
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUser({ ...user, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const { username, email, password } = user;
    try {
      await fetch("/user/edit", {
        method: "PUT",
        credentials: "include",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(user),
      });
      navigate("/admin", { msg: "user detail successfully updated" });

      //  .then(response => response.json())
    } catch (error) {
      console.log(error);
    }

    const userDetail = { username, password, email };
    console.log(userDetail);
  };

  return (
    <div className="container my-3">
      <h2 className="my-3">Edit user</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group mb-3">
          <label className="mb-1" htmlFor="username">
            Username
          </label>
          <input
            type="text"
            name="username"
            value={user.username}
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
            className="form-control"
            value={user.email}
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
            className="form-control"
            value={user.password}
            onChange={handleChange}
          />
        </div>
        <input type="hidden" value={user.id} name="id" />
        <button type="submit" className="btn btn-primary text-light mt-3">
          Update
        </button>
      </form>
      <Link className="btn btn-outline-primary mt-3" to="/admin">
        Cancel
      </Link>
    </div>
  );
};

export default EditUser;
