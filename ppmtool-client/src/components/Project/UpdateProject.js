import React, { Component } from "react";
import { Container, Row, Col, Form, FormGroup, Input } from "reactstrap";
import { getProject } from "../../actions/projectActions";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import classnames from "classnames";

class UpdateProject extends Component {
  constructor() {
    super();
    this.state = {
      id: "",
      projectName: "",
      projectIdentifier: "",
      description: "",
      start_date: "",
      end_date: ""
    };
  }

  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.getProject(id, this.props.history);
  }
  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  render() {
    return (
      <div className="project">
        <Container>
          <Row>
            <Col className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Update Project form</h5>
              <hr />
              <Form>
                <FormGroup>
                  <Input
                    type="text"
                    className="form-control form-control-lg "
                    placeholder="Project Name"
                  />
                </FormGroup>
                <FormGroup>
                  <Input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Unique Project ID"
                    disabled
                  />
                </FormGroup>
                <FormGroup>
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="Project Description"
                  />
                </FormGroup>
                <h6>Start Date</h6>
                <FormGroup>
                  <Input
                    type="date"
                    className="form-control form-control-lg"
                    name="start_date"
                  />
                </FormGroup>
                <h6>Estimated End Date</h6>
                <FormGroup>
                  <Input
                    type="date"
                    className="form-control form-control-lg"
                    name="end_date"
                  />
                </FormGroup>

                <Input
                  type="submit"
                  className="btn btn-primary btn-block mt-4"
                />
              </Form>
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}

UpdateProject.proopTypes = {
  getProject: PropTypes.func.isRequired,
  project: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  project: state.project.project
});

export default connect(
  mapStateToProps,
  { getProject }
)(UpdateProject);
