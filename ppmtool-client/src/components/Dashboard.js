import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import CreateProjectButton from "./Project/CreateProject";
import { Container, Row, Col } from "reactstrap";
class Dashboard extends Component {
  render() {
    return (
      <div className="projects">
        <Container>
          <Row>
            <Col className="col-md-12">
              <h1 className="display-4 text-center">Projects</h1>
              <br />
              <CreateProjectButton />
              <br />
              <hr />
              <ProjectItem />
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}
export default Dashboard;
