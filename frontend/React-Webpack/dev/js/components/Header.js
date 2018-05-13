import React from "react";
import {Navbar, NavItem} from 'react-materialize';
import logo from '../../../img/logo.png';

export default class Header extends React.Component {
    render() {
        return (
            <Navbar brand={<img src={logo} className='logoImg'/>} right>
                <NavItem onClick={() => console.log('test click')}>Timetable</NavItem>
                <NavItem onClick={() => console.log('test click')}>About us</NavItem>
            </Navbar>
        );
    }
}
