import React from "react";
import {Row, Input, Button} from 'react-materialize';
import axios from 'axios';

export default class AddNewTrainingForm extends React.Component {
    constructor(props) {
        super(props);
        this.startTime = React.createRef();
        this.endTime = React.createRef();
        this.name = React.createRef();
        this.location = React.createRef();
        this.places = React.createRef();
        this.instructorId = React.createRef();
    }
    render() {
        return (<div>
            <Row>
            <Input ref={this.startTime} s={6} label="Start time" />
            <Input ref={this.endTime} s={6} label="End time" />
            <Input ref={this.name} s={6} label="Name" />
            <Input ref={this.location} s={6} label="Location" />
            <Input ref={this.places} s={6} label="Amount of places" />
            <Input ref={this.instructorId} s={6} label="Instructor id" />
        </Row>
            <Row>
                <Button className='green addTrainingButton' onClick={() => {
                    let me = this;
                    axios.post('http://localhost:8080/timetable', {
                        startTime: me.startTime.current.state.value,
                        endTime: me.endTime.current.state.value,
                        name: me.name.current.state.value,
                        location: me.location.current.state.value,
                        places: me.places.current.state.value,
                        instructorId: me.instructorId.current.state.value
                    }).then( () => {
                        axios.get('http://localhost:8080/timetable').then( (response) => {
                            me.props.updateTimetable(response.data)
                        })
                    })
                }}>Accept</Button>
            </Row>
        </div>);
    }
}
