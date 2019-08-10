import React, { Component } from "react";
import { Button, Nav, NavItem, Container } from "reactstrap";
class Header extends Component {
  render() {
    return (
      <Nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
        <Container>
          <a className="navbar-brand" href="Dashboard.html">
            Personal Project Management Tool
          </a>
          <Button
            className="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#mobile-nav"
          >
            <span className="navbar-toggler-icon" />
          </Button>

          <div className="collapse navbar-collapse" id="mobile-nav">
            <ul className="navbar-nav mr-auto">
              <NavItem>
                <a className="nav-link" href="/dashboard">
                  Dashboard
                </a>
              </NavItem>
            </ul>

            <ul className="navbar-nav ml-auto">
              <NavItem>
                <a className="nav-link " href="register.html">
                  Sign Up
                </a>
              </NavItem>
              <NavItem>
                <a className="nav-link" href="login.html">
                  Login
                </a>
              </NavItem>
            </ul>
          </div>
        </Container>
      </Nav>
    );
  }
}
export default Header;
