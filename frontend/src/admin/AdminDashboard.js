import React, { useState, useEffect } from "react";
import { Link, useParams } from "react-router-dom";
import styled from "styled-components";

const Wrapper = styled.div`
  min-height: 50vh;
  padding: 30px;

  .adduser {
    display: flex;
    justify-content: end;
  }
`;

function AdminDashboard() {
  const [users, setUsers] = useState([]);
  const { id } = useParams();

  const getUser = async () => {
    try {
      const resp = await fetch("/user");
      const data = await resp.json();
      setUsers(data);
      //   console.log(data.length);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getUser();
  }, []);

  const deleteUser = async (id) => {
    await fetch(`/user/delete/${id}`, { method: "DELETE" });
    getUser();
  };

  return (
    <Wrapper>
      <h2 className="m-3">Welcome to Admin Dashboard</h2>
      <div className="adduser my-3">
        <Link className="btn btn-primary" to="/user/create">
          Add User
        </Link>
      </div>
      <div className="users m-3">
        <table className="table table-striped">
          {users.length > 0 && (
            <>
              <thead>
                <tr>
                  <th scope="col">No</th>
                  <th scope="col">Name</th>
                  <th scope="col">Email</th>
                  <th scope="col">Detail</th>
                  <th scope="col">Edit</th>
                  <th scope="col">Delete</th>
                </tr>
              </thead>
              <tbody>
                {users.map((user) => (
                  <tr key={user.id}>
                    <td>{user.id}</td>
                    <th scope="row">{user.username}</th>
                    <td>{user.email}</td>
                    <td>
                      <Link
                        className="btn btn-outline-info"
                        to={`/user/${user.id}`}
                      >
                        View
                      </Link>
                    </td>
                    <td>
                      <Link
                        className="btn btn-secondary"
                        to={`/user/edit/${user.id}`}
                      >
                        <i className="fa-regular fa-pen-to-square"></i>
                      </Link>
                    </td>
                    <td>
                      <button
                        className="btn btn-danger"
                        onClick={() => deleteUser(user.id)}
                      >
                        <i className="fa-solid fa-trash-can"></i>
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </>
          )}
        </table>
      </div>
    </Wrapper>
  );
}

export default AdminDashboard;
