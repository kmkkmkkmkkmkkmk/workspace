import React, { useState } from 'react';

const Test1 = (props) => {

  const [count, setCount] = useState(props.init);

 



  return(
    <div>

      <button id='mBtn' onClick={() =>  setCount(count -1) }>-</button>
      {count}
      
      <button id='pBtn' onClick={() => { setCount(count + 1) }}>+</button>

    </div>

   

  );

}


// function FunctionEx() {
//   const [count, setCount] = useState(0);
//   const clickHandler1 = () => {
//     setCount( () => -1);
//   }
  
//   const clickHandler2 = () => {
//     setCount( () => +1);
//   }

//   return(
//     <div>

//       <button id='mBtn' onClick={() =>  setCount(count -1) }>-</button>
//       {count}
      
//       <button id='pBtn' onClick={() =>  setCount(count + 1) }>+</button>

//     </div>

//   );


// }


export default Test1;
// export default FunctionEx;
