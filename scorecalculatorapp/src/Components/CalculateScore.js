import React, { useState } from 'react';
import '../Stylesheets/mystyle.css';

const CalculateScore = () => {
  const [name, setName] = useState('');
  const [school, setSchool] = useState('');
  const [total, setTotal] = useState('');
  const [goal, setGoal] = useState('');
  const [average, setAverage] = useState(null);

  const handleCalculate = () => {
    if (total && goal && !isNaN(total) && !isNaN(goal)) {
      const avg = ((parseFloat(total) / parseFloat(goal)) * 100).toFixed(2);
      setAverage(avg);
    } else {
      alert("Enter valid numbers for Total and Goal");
    }
  };

  return (
    <div className="container">
      <h2 className="title">Student Details:</h2>

      <input type="text" placeholder="Enter Name" onChange={(e) => setName(e.target.value)} />
      <input type="text" placeholder="Enter School" onChange={(e) => setSchool(e.target.value)} />
      <input type="number" placeholder="Enter Total Marks" onChange={(e) => setTotal(e.target.value)} />
      <input type="number" placeholder="Enter Maximum Marks (Goal)" onChange={(e) => setGoal(e.target.value)} />

      <button onClick={handleCalculate}>Calculate</button>

      {average && (
        <div className="result">
          <p><span className="label name">Name:</span> <span className="value name">{name}</span></p>
          <p><span className="label school">School:</span> <span className="value school">{school}</span></p>
          <p><span className="label total">Total:</span> <span className="value total">{total} Marks</span></p>
          <p><span className="label score">Score:</span> <span className="value score">{average}%</span></p>
        </div>
      )}
    </div>
  );
};

export default CalculateScore;
