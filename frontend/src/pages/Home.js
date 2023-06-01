import React, { useEffect, useState } from "react";
import styled from "styled-components";
import { Tablet } from "../Responsive";

const Wrapper = styled.div`
  min-height: 50vh;
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
      <div classname="container">
        <h2>Welcome to Motez</h2>
        <h4>Get the best and latest products here </h4>
      </div>
    </Wrapper>
  );
}

export default Home;
