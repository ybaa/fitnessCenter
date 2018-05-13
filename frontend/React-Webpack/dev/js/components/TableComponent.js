import React from "react";
import {Table, Button, Col, Row, Modal} from 'react-materialize';
import axios from 'axios';
import AddNewTrainingForm from './AddNewTrainingForm'

export default class TableComponent extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            timetable: []
        };
        this.updateTimetable = this.updateTimetable.bind(this)
    };

    updateTimetable(timetable){
      this.setState({
          timetable: timetable
      })
    };

    componentWillMount(){
        let me = this;
        axios.get('http://localhost:8080/timetable')
            .then(function (response) {
                me.setState({
                    timetable: response.data
                });
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    render() {
        let me = this;
        let tableContent = this.state.timetable.length > 0 ? this.state.timetable.map( (item, index) => {
            let startTime = new Date(item.startTime);
            let endTime = new Date(item.endTime);

            return <tr key={index}>
                <td>{startTime.toDateString()}</td>
                <td>{startTime.toLocaleTimeString()}</td>
                <td>{endTime.toLocaleTimeString()}</td>
                <td>{item.name}</td>
                <td>{item.places}</td>
                <td>{item.location}</td>
                <td>{item.instructorId}</td>
                <td><Button floating  className='red' waves='light' onClick={() => {
                    axios.delete(`http://localhost:8080/timetable/${item.id}`).then( () => {
                        axios.get('http://localhost:8080/timetable')
                            .then(function (response) {
                                me.setState({
                                    timetable: response.data
                                });
                            })
                    })

                }}>x</Button></td>
            </tr>
        })
            : <tr>
                <td/>
                <td/>
                <td/>
                <td>No workouts</td>
                <td/>
                <td/>
                <td/>
            </tr>;

        return (
            <div>
                <Row>
        <Col m={10} l={10} offset="m1 l1" className='tableStyle'>
            <Table className="striped centered">
                <thead>
                <tr>
                    <th>Date</th>
                    <th>Start time</th>
                    <th>End time</th>
                    <th>Name</th>
                    <th>Places</th>
                    <th>Location</th>
                    <th>Instructor</th>
                </tr>
                </thead>
                <tbody>
                 {tableContent}
                </tbody>
            </Table>
        </Col>
                </Row>
                <Row>
                    <Col m={10} l={10} offset="m1 l1">
                        <Modal
                            header='Add new training'
                            trigger={<Button className='green addTrainingButton'>Add training +</Button>}>
                            <AddNewTrainingForm updateTimetable={this.updateTimetable} />
                        </Modal>
                    </Col>
                </Row>
            </div>
        );
    }
}
