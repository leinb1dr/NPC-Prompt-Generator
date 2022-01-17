import React from 'react';
import {Container} from '@mui/material';
import PropTypes from 'prop-types';

class TabPanel extends React.Component{

    render() {
        let { children, value, index } = this.props
        return (
            <div
                role="tabpanel"
                hidden={value !== index}
                >
                {value === index && (
                    <Container>
                      {children}
                    </Container>
                )}
            </div>)
    }


}

TabPanel.propTypes = {
      children: PropTypes.node,
      index: PropTypes.number.isRequired,
      value: PropTypes.number.isRequired,
    };

export default TabPanel;