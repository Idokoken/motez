import React, { useEffect, useState } from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";
import { Tablet } from "../Responsive";

const Wrapper = styled.div`
  min-height: 50vh;

  .admin {
    display: flex;
    justify-content: end;
  }

  a {
    color: white;
  }
`;

function Home() {
  const [category, setCategory] = useState([]);

  const getCategory = async () => {
    try {
      const resp = await fetch("/api/category");
      const data = await resp.json();
      setCategory(data);
      console.log(data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getCategory();
  }, []);

  return (
    <Wrapper>
      <div className="container">
        <h2>Welcome to Motez</h2>
        <h4>Get the best and latest products here</h4>
        <div className="admin">
          <Link to="/admin" className="btn btn-info">
            Admin Page
          </Link>
        </div>
      </div>
    </Wrapper>
  );
}

export default Home;
