import React from 'react';

class Npc extends React.Component {

    constructor(props) {
        super(props);
		this.state = {npc: {}};
	}

    componentDidMount() {
        fetch('/npc').then(res => res.json())
        .then(data=>this.setState({npc: data}));
    }

    render() {
      return (
      <div>
        <div>Appearance: {this.state.npc.appearance && this.state.npc.appearance.text} </div>
        <div>HighAbility: {this.state.npc.highAbility} </div>
        <div>LowAbility: {this.state.npc.lowAbility} </div>
        <div>Mannerism: {this.state.npc.mannerisms && this.state.npc.mannerisms.text} </div>
        <div>Interaction: {this.state.npc.interaction && this.state.npc.interaction.text} </div>
        <div>Ideal: {this.state.npc.ideal && this.state.npc.ideal.text} </div>
        <div>Bond: {this.state.npc.bond && this.state.npc.bond.text} </div>
        <div>Flaw: {this.state.npc.flaw && this.state.npc.flaw.text} </div>
        </div>
      );
    }
}

export default Npc