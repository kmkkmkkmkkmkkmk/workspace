import './App.css';

// import 여기서사용할이름 from './js파일경로';
import ClassComponent from './components/R01_ClassComponent';

import FunctionComponent from './components/R02_FunctionComponent';

/*  JSX  <= JS XML */

/* ======================================================== */
/* 
   - React의 컴포넌트는 딱 하나의 요소만을 반환할 수 있다
   - 여러 요소를 반환하고 싶을 때 부모 요소로 묶어준다!
*/
/* ======================================================== */
function App() {
  return (
    /* <></> (fragment, 조각) : 반환되는 요소를 감싸는 태그, 해석 X */
    <>
      <h1>테스트</h1>
      <ClassComponent/>
      
      {/* jsx 주석 */}
      {/* <ClassComponent/> */}
      
      <hr/>

      <FunctionComponent/>
      {/* <FunctionComponent/> */}

    </>
  );
  
}

export default App;
