import React, { Component } from "react";
import ProjectTask from "./ProjectTasks/ProjectTask";
import { Container, Row, Col } from "reactstrap";
class Backlog extends Component {
  render() {
    const { project_tasks } = this.props;
    const tasks = project_tasks.map(project_task =>(<ProjectTask key={project_task.id} project_task = {project_task}))
    return (
      <Container>
        <Row>
          <Col className="col-md-4">
            <div className="card text-center mb-2">
              <div className="card-header bg-secondary text-white">
                <h3>TO DO</h3>
              </div>
            </div>
            <ProjectTask />
          </Col>
          <Col className="col-md-4">
            <div className="card text-center mb-2">
              <div className="card-header bg-primary text-white">
                <h3>In Progress</h3>
              </div>
            </div>
            {
              //  <!-- SAMPLE PROJECT TASK STARTS HERE -->
              //         <!-- SAMPLE PROJECT TASK ENDS HERE -->
            }
          </Col>
          <Col className="col-md-4">
            <div className="card text-center mb-2">
              <div className="card-header bg-success text-white">
                <h3>Done</h3>
              </div>
            </div>
            {
              // <!-- SAMPLE PROJECT TASK STARTS HERE -->
              // <!-- SAMPLE PROJECT TASK ENDS HERE -->
            }
          </Col>
        </Row>
      </Container>
    );
  }
}

export default Backlog;
