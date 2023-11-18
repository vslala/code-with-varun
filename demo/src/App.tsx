import React from 'react';
import './App.css';
import AppViewModel from "./App.vm";

function App() {
  const vm = AppViewModel();

  return (
    <div className="container py-5">
      <div className="row">
        <div className="col">
          <button className="btn btn-primary" onClick={vm.incrementCounter}>Increment Counter</button>
        </div>
        <div className="col">
          <div className="card">
            <div className="card-body">
              <h2>
                {vm.counter}
              </h2>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
