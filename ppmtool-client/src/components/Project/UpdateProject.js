import React, { Component } from "react";
import { Container, Row, Col, Form, FormGroup, Input } from "reactstrap";

class UpdateProject extends Component {
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
export default UpdateProject;
