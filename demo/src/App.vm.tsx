import {useEffect, useMemo, useState} from "react";
import {IntegrationServiceProvider} from "./integration-service";

const AppViewModel = () => {
    const integrationService = useMemo(() => IntegrationServiceProvider.getInstance(), []);
    const [counter, setCounter] = useState(0);

    const incrementCounter = async () => {
        let count = counter + 1;
        await integrationService.save(count);
        setCounter(count);
    }

    useEffect(() => {
        const loadCounter = async () => {
            const count = await integrationService.fetch();
            setCounter(count);
        }

        loadCounter();
    }, [integrationService]);

    return {incrementCounter, counter};
}

export default AppViewModel;