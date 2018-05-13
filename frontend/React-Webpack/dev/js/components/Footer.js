import React from "react";
import {Footer} from 'react-materialize'

export default class Footerr extends React.Component {
    render() {
        return (<Footer copyrights="&copy 2018 All Rights Reserved"
                        links={
                            <ul>
                                <li><a className="grey-text text-lighten-3" href="#!">Timetable</a></li>
                                <li><a className="grey-text text-lighten-3" href="#!">About Us</a></li>
                            </ul>
                        }
                        className='example'
        >
            <h5 className="white-text">Addiction Fitness Center</h5>
            <p className="grey-text text-lighten-4">The best fitness center in Wroclaw</p>
        </Footer>);
    }
}
