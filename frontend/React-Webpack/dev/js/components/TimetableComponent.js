import React from "react";
import Footerr from "./Footer";
import Header from "./Header";
import TableComponent from './TableComponent';
import { Row } from 'react-materialize';
require('../../scss/style.scss');

export default class TimetableComponent extends React.Component {
    render() {
        return (
            <div>
                <Header />
                <Row>
                <TableComponent/>
                </Row>
                <Footerr />
            </div>
        );
    }
}
