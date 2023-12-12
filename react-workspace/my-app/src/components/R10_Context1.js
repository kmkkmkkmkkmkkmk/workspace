import React, { createContext, useContext } from 'react';


/* 1. Context 객체 생성 */
const TestContext = createContext();


/* 4. 손주 (2단계 하위) 컴포넌트 */
const GrandChild = () => {

  const temp = useContext(TestContext); // TestContext에 저장된 값을 temp에 대입

  return(
    <>
      <h3>GrandChild Components ( {temp} )</h3>
    </>

  );
}

/* 3. 자식 (1단계 하위) 컴포넌트 */
const Child = () => {
  return (
    <>
      {/* 여기서 하위 컴포넌트인 GrandChild로 전달하는 값이 없음 */}
      <h2>Child Component</h2>
      <GrandChild/>
    </>
  );
}


const Parent = () => {

  return(
    /* Context에 값을 추가 -> 모든 하위 컴포넌트에게 제공 */

    <TestContext.Provider value='Parent에서 전달한 값'>
      <h1>Parent Component</h1>

      <Child/> {/* Child 포함 모든 하위 컴포넌트에서 Parent가 제공한 value 사용 가능 */}
    </TestContext.Provider>
  );
}

export default Parent;

























