import React, { Component } from "react";

import { Link } from "react-router-dom";
import { Container, Row, Col } from "reactstrap";
import { connect } from "react-redux";
import { deleteProject } from "../../actions/projectActions";
import PropTypes from "prop-types";
class ProjectItem extends Component {
  onDeleteClicked = id => {
    this.props.deleteProject(id);
  };
  render() {
    const { project } = this.props;
    return (
      <Container>
        <div className="card card-body bg-light mb-3">
          <Row>
            <Col className="col-2">
              <span className="mx-auto">{project.projectIdentifier}</span>
            </Col>
            <Col className="col-lg-6 col-md-4 col-8">
              <h3>{project.projectName}</h3>
              <p>{project.description}</p>
            </Col>
            <Col className="col-md-4 d-none d-lg-block">
              <ul className="list-group">
                <Link to={`/projectBoard/${project.projectIdentifier}`}>
                  <li className="list-group-item board">
                    <i className="fa fa-flag-checkered pr-1"> Project Board </i>
                  </li>
                </Link>
                <Link to={`/updateProject/:${project.projectIdentifier}`}>
                  <li className="list-group-item update">
                    <i className="fa fa-edit pr-1"> Update Project Info</i>
                  </li>
                </Link>

                <li
                  className="list-group-item delete"
                  onClick={this.onDeleteClicked.bind(
                    this,
                    project.projectIdentifier
                  )}
                >
                  <i className="fa fa-minus-circle pr-1"> Delete Project</i>
                </li>
              </ul>
            </Col>
          </Row>
        </div>
      </Container>
    );
  }
}
ProjectItem.propTypes = {
  deleteProject: PropTypes.func.isRequired
};
export default connect(
  null,
  { deleteProject }
)(ProjectItem);
