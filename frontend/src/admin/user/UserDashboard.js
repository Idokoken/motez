import React, { useState, useEffect } from "react";
import { Link, useParams } from "react-router-dom";
import styled from "styled-components";

const Wrapper = styled.div`
  padding: 30px;
  min-height: 50vh;

  span {
    margin-right: 50px;
  }
`;

const UserDashboard = () => {
  const { id } = useParams();
  const [user, setUser] = useState({});

  useEffect(() => {
    const getUser = async () => {
      try {
        const resp = await fetch(`/user/${id}`);
        const data = await resp.json();
        setUser(data);
        console.log(data);
      } catch (error) {
        console.log(error);
      }
    };
    getUser();
  }, [id]);

  return (
    <Wrapper>
      <h2>User Profile</h2>
      <div className="userdetail">
        <div className="my-3">
          <span>Username: </span> {user.username}
        </div>
        <div className="my-3">
          <span>Email: </span>
          {user.email}
        </div>
        <div className="my-3">
          <span>Password: </span> {user.password}
        </div>
      </div>
      <Link to={`/user/edit/ ${user.id}`} className="btn btn-info">
        Update
      </Link>
    </Wrapper>
  );
};

export default UserDashboard;
